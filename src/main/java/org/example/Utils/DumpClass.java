package org.example.Utils;

public class DumpClass implements DumpInterface {
	private final boolean value;

	public DumpClass(boolean value) {
		this.value=value;
	}
	public boolean getValue(){
		return value;
	}
}
