package org.example.DefendencyInjection;

import org.example.Utils.DumpClass;
import org.example.Utils.DumpInterface;

/**
 * dumpClass.value의 값으로 isValid 메소드 결과값이 리턴됨.
 * 1. 유연하지 않음.
 * 2. WrongExam 클래스들은 DumpClass를 의존하게 됨.
 */
public class DefendencyExam {
	//정적 유틸리티를 잘못 사용한 예
	public class WrongExam01{
		private final static DumpClass dumpClass=new DumpClass(true);
		public boolean isValid(){
			return dumpClass.getValue();
		}
	}
	// 싱글톤을 잘못 사용한 예
	public class WrongExam02{
		private static DumpClass dumpClass = new DumpClass(true);
		public boolean isValid(){
			return dumpClass.getValue();
		}
	}

	/**
	 * CorrectExam01 클래스를 호출하는 시점에서 DumpClass를 주입해줌
	 * 1. 유연한 관리 가능
	 * > DumpClass가 인터페이스라면 공변타입타이핑 특성을 이용해 DumpClass을 구현한 클래스를 주입할수 있음
	 */
	public class CorrectExam01{
		private final DumpInterface dumpClass;
		public CorrectExam01(DumpClass dumpClass) {
			this.dumpClass = dumpClass;
		}
	}
}
