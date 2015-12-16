package gildedrose;

public class NormalObject extends UpdateInterface {

	@Override
	public void updateQuality(Item item) {
		item.sellIn--;
		
		if (item.sellIn >= 0)
			item.quality--;
		else
			item.quality -= 2;

		keepQualityInRange(item);
	}

	private void keepQualityInRange(Item item) {
		if (item.quality < 0)
			item.quality = 0;
		if (item.quality > 50)
			item.quality = 50;
	}

}
