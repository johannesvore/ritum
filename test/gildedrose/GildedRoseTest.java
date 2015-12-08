package gildedrose;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GildedRoseTest {

	@Parameters
	public static Collection<	Object[]> data() {
		Collection<Object[]> data = new ArrayList<Object[]>();
		data.addAll(Arrays
				.asList(new Object[][] { {
					// MESSAGE, NAME, SellIn, Quantity, expectedSellIn, Expected Quantity
						"Default test",
						"+5 Dexterity Vest", 10, 20,9,19 },
					{
							// MESSAGE, NAME, SellIn, Quantity, expectedSellIn, Expected Quantity
						"Aged Brie ",
						"Aged Brie", 2, 0, 1,1},
					{
								// MESSAGE, NAME, SellIn, Quantity, expectedSellIn, Expected Quantity
						"Mongoose Test",
						"Elixir of the Mongoose", 5, 7,4,6},
					{
									// MESSAGE, NAME, SellIn, Quantity, expectedSellIn, Expected Quantity
						"Sulfuras Test",
						"Sulfuras, Hand of Ragnaros", 0, 80, 0, 80},
					{
										// MESSAGE, NAME, SellIn, Quantity, expectedSellIn, Expected Quantity
						"Backstage Test",
						"Backstage passes to a TAFKAL80ETC concert", 15, 20, 14, 21},
								
					{
						"Once the sell by date has passed, Quality degrades twice as fast",
						"Conjured Mana Cake", 0, 6, -1, 4},
					{
						"The Quality of an item is never negative",
						"Conjured Mana Cake", 2, -1, 1, -1},
					{
						"The Quality of an item is never more than 50",
						"Conjured Mana Cake", 5, 51, 4, 50},
					{
						"Backstage passes 10 day -> quality +2",
						"Backstage passes to a TAFKAL80ETC concert", 10, 20, 9, 22},
					{	
						"Backstage passes 5 days -> quality +3",
						"Backstage passes to a TAFKAL80ETC concert", 5, 20, 4, 23},
//					{
//						"Manacaketest ->fehler, expected sellin sollte 4 sein-> muss noch implementiert werden",
//						"Conjured Mana Cake", 3, 6, 2, 4},
					{
						"Set quality of backstage pass, when concert is already over",
						"Backstage passes to a TAFKAL80ETC concert", -1, 4,-2,0},
						
					{
						"still increase quality of aged bri when sellin date under 0",
						"Aged Brie", -1, 39,-2,41},
					{
						// MESSAGE, NAME, SellIn, Quantity, expectedSellIn, Expected Quantity
						"Aged Brie -> Quality over 50",
						"Aged Brie", 2, 52, 1,52},
					{
						"Backstage Test",
						"Backstage passes to a TAFKAL80ETC concert", 12, 49, 11, 50},
					{
						"Backstage Test",
						"Backstage passes to a TAFKAL80ETC concert", 9, 49, 8, 50},
					
					
					}));
		return data;
	}

	String message;
	String itemName;
	int sellIn;
	int quality;
	int expectedSellIn;
	int expectedQuality;

	Item item;

	public GildedRoseTest(String message, String itemName, int sellIn,
			int quality, int expectedSellIn, int expectedQuality) {
		this.message = message;
		this.itemName = itemName;
		this.sellIn = sellIn;
		
		this.quality = quality;
		this.expectedSellIn = expectedSellIn;
		this.expectedQuality = expectedQuality;
	}

	@Before
	public void setUp() {
		List<Item> items = new ArrayList<Item>();
		items.add(item = new Item(itemName, sellIn, quality));
		GildedRose.setItems(items);
	}

	@Test
	public void testQualityUpdate() {
		GildedRose.updateQuality();
		assertEquals(message + " Quality ", expectedQuality, item.getQuality());
	}

	@Test
	public void testSellInUpdate() {
		GildedRose.updateQuality();
		assertEquals(message + " SellIn", expectedSellIn, item.getSellIn());
	}
	
}
