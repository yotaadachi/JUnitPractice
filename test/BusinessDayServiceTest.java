package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class BusinessDayServiceTest {

    @Test
    public void testIsBussinessDay() {
    	// オブジェクトの生成
    	BusinessDayService bds = new BusinessDayService();
    	// 実行
    	assertTrue(bds.isBusinessDay(LocalDate.of(2022, 1, 6)));
    }

    @Test
    public void testHolidaysNotBusinessDay() {
    	// オブジェクトの生成
    	BusinessDayService bds = new BusinessDayService();
    	// 実行
    	assertFalse(bds.isBusinessDay(LocalDate.of(2022, 1, 1)));
    }

    @Test
    public void testSaturdayIsNotBusinessDay() {
    	// オブジェクトの生成
    	BusinessDayService bds = new BusinessDayService();
    	// 実行
    	assertFalse(bds.isBusinessDay(LocalDate.of(2024, 7, 13)));
    }

    @Test
    public void testSundayIsNotBusinessDay() {
    	// オブジェクトの生成
    	BusinessDayService bds = new BusinessDayService();
    	// 実行
    	assertFalse(bds.isBusinessDay(LocalDate.of(2024, 7, 14)));
    }

    @Test
    public void testGetNextBusinessDayIsNull() {
    	// オブジェクトの生成
    	BusinessDayService bds = new BusinessDayService();
    	// 実行
    	assertNull(bds.getNextBusinessDay(LocalDate.of(2022, 8, 11), 5));
    }

    @Test
    public void testGetNextBusinessDay() {
    	// オブジェクトの生成
    	BusinessDayService bds = new BusinessDayService();
    	// 実測値
    	LocalDate actual = bds.getNextBusinessDay(LocalDate.of(2022, 9, 23), 5);
    	// 実行
    	assertEquals(LocalDate.of(2022, 9, 26), actual);
    }

    @Test
    public void testGetBusinessDayArray() {
    	// オブジェクト生成
    	BusinessDayService bds = new BusinessDayService();
    	// 期待値
    	LocalDate[] expected = new LocalDate[] {
    		LocalDate.of(2022, 10, 7),
    		LocalDate.of(2022, 10, 11),
    		LocalDate.of(2022, 10, 12)
    	};
    	// 実測値
    	LocalDate[] actual = bds.getBusinessDayArray(LocalDate.of(2022, 10, 7),5);
    	// 実行
    	assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetBusinessDayList() {
    	// オブジェクト生成
    	BusinessDayService bds = new BusinessDayService();
    	// 期待値
    	List<LocalDate> expected = Arrays.asList(
    		LocalDate.of(2022, 10, 7),
    		LocalDate.of(2022, 10, 11),
    		LocalDate.of(2022, 10, 12)
    	);
    	// 実測値
    	List<LocalDate> actual = bds.getBusinessDayList(LocalDate.of(2022, 10, 7), 5);
    	// 実行
    	assertIterableEquals(expected, actual);
    }


}
