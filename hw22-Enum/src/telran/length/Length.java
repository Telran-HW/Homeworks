package telran.length;

public class Length {

	int number;
	LengthUnit measure;

	public Length(int number, LengthUnit measure) {
		super();
		this.number = number;
		this.measure = measure;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((measure == null) ? 0 : measure.hashCode());
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Length))
			return false;
		Length other = (Length) obj;
		if (measure != other.measure)
			return false;
		if (number != other.number)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "" + number + measure;
	}

	public Length plus(Length l) {
		
		if(!measure.equals(l.measure)) {
			Length temp = l.convert(measure);
			return new Length(number + temp.number, measure);
		}
		return new Length(number + l.number, measure);
	}

	public Length convert(LengthUnit other) {
		double num = number * measure.convertToOther(other);
		return new Length((int) num, other);
	}

	public Length minus(Length l) {
		if(!measure.equals(l.measure)) {
			Length temp = l.convert(measure);
			return new Length(number - temp.number, measure);
		}
		return new Length(number - l.number, measure);
	}

}
