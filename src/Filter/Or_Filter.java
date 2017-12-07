package Filter;

import Ex0.WiFi_Scan;

public class Or_Filter implements filter{
	private filter _f1, _f2;
	public Or_Filter(filter f1, filter f2) {
		_f1 = f1;
		_f2 = f2;
	}

	public boolean test(WiFi_Scan rec) {
		return _f1.test(rec) || _f2.test(rec);
	}
}