package gildedrose;

public class AgedBrie extends UpdateInterface {

	@Override
	public void updateQuality(Item item) {
		item.sellIn--;
		item.quality++;

		if (item.quality > 50)
			item.quality = 50;
	}

}
