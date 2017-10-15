package com.bolly.spike.report;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * 报表的抽象类
 * Author   : Bolly
 * CreateAt : 2017/09/24 19:32:43
 */
public abstract class AbstractReport {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractReport.class);

    protected String templateFilePath; //模板文件

    protected String temporaryFilePath; //临时文件

    protected Workbook workbook;

    public AbstractReport(String templateFilePath) {
        this.templateFilePath = templateFilePath;
    }

    /**
     * 生成临时文件。
     * 临时文件夹不存在则会自动生成对应的目录
     *
     * @throws IOException 生成临时目录失败
     */
    protected void generateTemporaryFilePath() throws IOException {
        String uuid = UUID.randomUUID().toString();
        String reportDir = FilenameUtils.getFullPath(templateFilePath) + "tmp/";
        String extension = FilenameUtils.getExtension(templateFilePath);
        String baseName = FilenameUtils.getBaseName(templateFilePath);

        FileUtils.forceMkdir(new File(reportDir));

        this.temporaryFilePath = StringUtils.join(reportDir, baseName, "(" + uuid + ")." + extension);
    }


    /**
     * 导出报表。
     * 包括一下几步：
     * 1、读取模板文件
     * 2、写入数据
     * 3、导出到临时文件
     *
     * @return 临时文件路径
     * @throws Exception 文件没找到
     */
    public String export() throws Exception {
        generateTemporaryFilePath();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            LOGGER.info("Start export report.");
            fis = new FileInputStream(templateFilePath);
            workbook = WorkbookFactory.create(fis);
            writeDataToWorkbook();

            fos = new FileOutputStream(temporaryFilePath);
            workbook.write(fos);

            LOGGER.info("Export report success.report path = " + temporaryFilePath);
            return temporaryFilePath;
        } finally {
            closeFileStream(fis);
            closeFileStream(fos);
        }
    }

    protected abstract void writeDataToWorkbook();

    /**
     * 关闭文件流
     *
     * @param fileStream 文件流
     */
    private void closeFileStream(Closeable fileStream) {
        if (fileStream == null) {
            return;
        }
        try {
            fileStream.close();
        } catch (IOException e) {
            LOGGER.warn("关闭文件流失败.", e);
        }
    }

    //region Excel操作的通用方法

    /**
     * 拷贝行样式。除单元格数据外，其它内容都拷贝。
     *
     * @param sheet            工作表
     * @param originalRowIndex 原始数据所在行
     * @param targetRowIndex   目标数据所在行
     */
    protected void copyRowStyle(Sheet sheet, int originalRowIndex, int targetRowIndex) {
        Row originalRow = sheet.getRow(originalRowIndex);
        if (originalRow == null) {
            throw new IllegalArgumentException("original row is empty.");
        }

        Row targetRow = sheet.getRow(targetRowIndex);
        if (targetRow == null) {
            targetRow = sheet.createRow(targetRowIndex);
        }
        copyRowStyle(originalRow, targetRow);
    }

    /**
     * 拷贝行样式。除单元格数据外，其它内容都拷贝。
     *
     * @param originalRow 原始行
     * @param targetRow   目标行
     */
    protected void copyRowStyle(Row originalRow, Row targetRow) {
        if (originalRow == null) {
            throw new IllegalArgumentException("original row can't be null.");
        }
        if (targetRow == null) {
            throw new IllegalArgumentException("target row can't be null.");
        }

        targetRow.setHeight(originalRow.getHeight());

        short firstCellNum = originalRow.getFirstCellNum();
        short lastCellNum = originalRow.getLastCellNum();

        for (short i = firstCellNum; i < lastCellNum; i++) {
            Cell originalCell = originalRow.getCell(i);
            if (originalCell == null) {
                targetRow.createCell(i);
                continue;
            }
            Cell targetCell = targetRow.getCell(i);
            if (targetCell == null) {
                targetCell = targetRow.createCell(i);
            }
            copyCellStyle(originalCell, targetCell);
        }
    }

    /**
     * 拷贝单元格样式
     *
     * @param originalCell 原始单元格
     * @param targetCell   目标单元格
     */
    protected void copyCellStyle(Cell originalCell, Cell targetCell) {
        targetCell.setCellStyle(originalCell.getCellStyle());
    }

    /**
     * @param sheet
     * @param rowIndex
     * @param columnIndex
     * @param data
     */
    protected void writeCellData(Sheet sheet, int rowIndex, int columnIndex, Object data) {
        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            copyRowStyle(sheet, rowIndex - 1, rowIndex);
            row = sheet.getRow(rowIndex);
        }
        Cell cell = row.getCell(columnIndex);
        if (data instanceof String) {
            cell.setCellValue((String) data);
        } else if (data instanceof Date) {
            cell.setCellValue((Date) data);
        } else if (data instanceof Double) {
            cell.setCellValue((Double) data);
        } else if (data instanceof Calendar) {
            cell.setCellValue((Calendar) data);
        } else if (data instanceof RichTextString) {
            cell.setCellValue((RichTextString) data);
        } else {
            cell.setCellValue(data.toString());
        }
    }

    //endregion

}
