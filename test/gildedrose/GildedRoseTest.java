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
						"Normal Object Test",
						"+5 Dexterity Vest", 10, 20,9,19 },
					{
						"Normal Object Test, Quality over 50",
						"+5 Dexterity Vest", 10, 52,9,50},
					{
						"Aged Brie Test",
						"Aged Brie", 2, 0, 1,1},
					{
						"still increase quality of aged brie when sellin date under 0",
						"Aged Brie", -1, 39,-2,40},
					{
						"Aged Brie -> Quality over 50",
						"Aged Brie", 2, 52, 1,50},
					{
						"Sulfuras Test",
						"Sulfuras, Hand of Ragnaros", 0, 80, 0, 80},
					{
						"The Quality of an item is never negative",
						"+5 Dexterity Vest", 2, -1, 1, 0},
					{
						"The Quality of an item is never more than 50",
						"+5 Dexterity Vest", 5, 51, 4, 50},
					{
						"Backstage Test",
						"Backstage passes to a TAFKAL80ETC concert", 15, 20, 14, 21},
					{
						"Backstage Test over 10 days",
						"Backstage passes to a TAFKAL80ETC concert", 12, 49, 11, 50},
					{
						"Backstage passes <=10 days -> quality +2",
						"Backstage passes to a TAFKAL80ETC concert", 10, 20, 9, 22},
					{	
						"Backstage passes <=5 days -> quality +3",
						"Backstage passes to a TAFKAL80ETC concert", 5, 20, 4, 23},
					{
						"Set quality of backstage pass to 0, when concert is already over",
						"Backstage passes to a TAFKAL80ETC concert", -1, 4,-2,0},
					{
						"Backstage Test quality over 50",
						"Backstage passes to a TAFKAL80ETC concert", 12, 52, 11, 50},
					{
						"Default test",
						"+5 Dexterity Vest", -1, 2, -2, 0 },
					{
						"Conjured test",
						"Conjured Mana Cake", 5, 4, 4, 2 
					}
				
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
	
	@Test
	public void testGetItemName() {
		Item newItem = new Item("Test Item",1,1);
		assertEquals("Test Item",newItem.getName());
	}
}
