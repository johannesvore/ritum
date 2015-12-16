package gildedrose;

public class UpdateFactory {

	public static UpdateInterface updateQuality(Item item) {
		if (item.name.startsWith("Conjured"))
			return new Conjured();
		if (item.name.startsWith("Sulfuras"))
			return new Sulfuras();
		if (item.name.startsWith("Aged"))
			return new AgedBrie();
		if (item.name.startsWith("Backstage"))
			return new Concert();
		else
			return new NormalObject();
	}

}
