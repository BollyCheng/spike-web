package com.bolly.spike.report.ups;

import com.bolly.spike.model.entity.ups.User;
import com.bolly.spike.report.AbstractReport;
import com.bolly.spike.service.ups.UserService;
import com.bolly.spike.util.ApplicationUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2017/09/24 19:39:21
 */
@Service
public class UserReport extends AbstractReport {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserReport.class);

    @Resource(name = "userService")
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserReport() {
        super(ApplicationUtils.getApplicationRootDir() + "report/user_list.xlsx");
    }

    private static final int DATA_START_ROW_INDEX = 2;//数据起始行

    private static final int EMPNO_COLUMN_INDEX = 2;//工号所在行
    private static final int NAME_COLUMN_INDEX = 3;//姓名所在列
    private static final int DEPT_COLUMN_INDEX = 4;//部门所在列

    @Override
    protected void writeDataToWorkbook() {
        LOGGER.info("Start export user report.");
        exportUserSheet();
        LOGGER.info("End of export user report.");
    }

    private void exportUserSheet() {
        LOGGER.info("Start export user sheet.");
        Sheet sheet = workbook.getSheetAt(0);

        List<User> users = userService.list();
        int rowIndex = DATA_START_ROW_INDEX;
        for (User user : users) {
            writeCellData(sheet, rowIndex, EMPNO_COLUMN_INDEX, user.getUsername());
            writeCellData(sheet, rowIndex, NAME_COLUMN_INDEX, user.getNickname());
            writeCellData(sheet, rowIndex, DEPT_COLUMN_INDEX, user.getDepartmentName());
        }
        LOGGER.info("End of export user report");
    }

}
