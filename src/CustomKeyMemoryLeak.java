import java.util.HashMap;
import java.util.Map;

public class CustomKeyMemoryLeak {
	public CustomKeyMemoryLeak(String name) {
		this.name = name;
	}

	private String name;

	public static void main(String[] args) {
		Map<CustomKeyMemoryLeak, String> map = new HashMap<CustomKeyMemoryLeak, String>();
		map.put(new CustomKeyMemoryLeak("Shamik"), "Shamik Mitra");
		String val = map.get(new CustomKeyMemoryLeak("Shamik"));
		System.out.println("Missing equals and hascode so value is not accessible from Map " + val);
	}
}
