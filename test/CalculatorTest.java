package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Nested
	public class taxPriceTest {
		@Test
		public void testTaxPrice() {
			// オブジェクトの生成
			Calculator cal = new Calculator();
			// 期待値
			int expected = 110;
			// 実測値
			int actual = cal.taxPrice(100);
			// 比較
			assertEquals(expected, actual);
		}

		@Test
		public void testTaxPriceException() {
			// オブジェクトの生成
			Calculator cal = new Calculator();
			// 実行
			assertThrows(IllegalArgumentException.class, () -> {
				cal.taxPrice(-100);
			});
		}
	}
}
