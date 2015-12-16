package gildedrose;

public class Sulfuras extends UpdateInterface {

	@Override
	public void updateQuality(Item item) {
		item.sellIn = 0;
		item.quality = 80;
	}
}
