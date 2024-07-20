package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
	}
}
