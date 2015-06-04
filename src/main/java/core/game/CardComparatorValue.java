package core.game;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class CardComparatorValue implements Comparator<Card> {
    @Override
    public int compare(Card a, Card b) {
        return a.getValue() < b.getValue() ? -1 : a.getValue() == b.getValue() ? 0 : 1;
    }

	
	@Override
	public Comparator<core.game.Card> reversed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<core.game.Card> thenComparing(
			Comparator<? super core.game.Card> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U extends Comparable<? super U>> Comparator<core.game.Card> thenComparing(
			Function<? super core.game.Card, ? extends U> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U> Comparator<core.game.Card> thenComparing(
			Function<? super core.game.Card, ? extends U> arg0,
			Comparator<? super U> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<core.game.Card> thenComparingDouble(
			ToDoubleFunction<? super core.game.Card> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<core.game.Card> thenComparingInt(
			ToIntFunction<? super core.game.Card> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<core.game.Card> thenComparingLong(
			ToLongFunction<? super core.game.Card> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
