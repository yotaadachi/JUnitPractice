package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

	@Nested
	public class taxPriceTest {

		Calculator cal;

		@BeforeEach
		public void Setup() {
			// オブジェクトの生成
			cal = new Calculator();
		}

		@Test
		public void testTaxPrice() {
			assumeTrue("DEV".equals(System.getenv("ENV")));
			// 期待値
			int expected = 110;
			// 実測値
			int actual = cal.taxPrice(100);
			// 比較
			assertEquals(expected, actual);
		}

		@Test
		@Tag("Exception")
		public void testTaxPriceException() {
			// 実行
			assertThrows(IllegalArgumentException.class, () -> {
				cal.taxPrice(-100);
			});
		}

		@ParameterizedTest
		@CsvSource({
			"8, 100, 108",
			"8, 3000, 3240",
			"10, 50, 55",
			"8, 50, 54",
			"5, 50, 52"
		})
		public void testTaxPriceParameterized(int rate, int price, int expected) {
			// オブジェクト生成
			Calculator calc = new Calculator();
			// 実測値
			int actual = calc.taxPrice(rate, price);
			System.out.println("rate:" + rate);
			System.out.println("price:" + price);
			System.out.println("expected:" + expected);
			System.out.println("--------------------");
			// 実行
			assertEquals(expected, actual);
		}
	}
}
