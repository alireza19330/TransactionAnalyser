package com.mebank;

import com.mebank.service.RelativeBalanceResponse;
import com.mebank.service.RelativeBalanceService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;

public class TransactionsAnalyserTest {

    private RelativeBalanceService relativeBalanceService;

    @Before
    public void importFile(){
        relativeBalanceService = new RelativeBalanceService();
    }

    @Test
    public void accountBalanceSimpleTest(){
        File file = new File(this.getClass().getResource("/input0.csv").getFile());
        RelativeBalanceResponse balance = relativeBalanceService.getBalance(file.getAbsolutePath(),
                "20/10/2018 12:00:00", "20/10/2018 19:00:00", "ACC334455");
        Assert.assertEquals(new BigDecimal(-35.00).longValue(), balance.getBalance().longValue());
    }

    @Test
    public void accountBalanceWithReversalTest(){
        File file = new File(this.getClass().getResource("/input.csv").getFile());
        RelativeBalanceResponse balance = relativeBalanceService.getBalance(file.getAbsolutePath(),
                "20/10/2018 12:00:00", "20/10/2018 19:00:00", "ACC334455");
        Assert.assertEquals(new BigDecimal(-25.00).longValue(), balance.getBalance().longValue());
    }

    @Test
    public void accountBalanceWithReversalAndDepositTest(){
        File file = new File(this.getClass().getResource("/input2.csv").getFile());
        RelativeBalanceResponse balance = relativeBalanceService.getBalance(file.getAbsolutePath(),
                "20/10/2018 12:00:00", "20/10/2018 19:00:00", "ACC334455");
        Assert.assertEquals(new BigDecimal(-20.00).longValue(), balance.getBalance().longValue());
    }
}

