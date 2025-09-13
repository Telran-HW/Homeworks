package telran.length;


public enum LengthUnit {

		MM(0.1), CM(1.), DM(10.), M(100.), KM(100_000.);
		
		double cmAmount;

		private LengthUnit(double cmAmount) {
			this.cmAmount = cmAmount;
		}
		
		public double convertToOther(LengthUnit other) {
			return this.cmAmount/other.cmAmount;
		}

//		Length l1 = new Length(10, LengthUnit.M);
//		Length l2 = new Length(1000, LengthUnit.CM);
//		Length l3 = new Length(20, LengthUnit.M);
		
//		assertEquals(-10000, LengthUnit.MM.between(l3, l2), 0.00001);
		//20M to 1000cm
		// 20000mm and 10000mm
//		assertEquals(10, LengthUnit.M.between(l2, l3), 0.00001);
		// 1000cm to 20m
		//10m and 20m
//		assertEquals(-1000, LengthUnit.CM.between(l3, l2), 0.00001);
		//20m and 1000cm
		//2000cm and 1000cm
		
		double between(Length l1, Length l2) {
			if(!l1.measure.equals(l2.measure)) {
				double kL1 = l1.measure.convertToOther(this);
				double kL2 = l2.measure.convertToOther(this);
				return l2.number*kL2 - l1.number*kL1;
			}
			return l2.number - l1.number;
		}

}
