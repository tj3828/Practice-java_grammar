package sample;

// 1줄짜리 빙고칸을 만들어 빙고게임

public class LineBingo {
	private int[] nums;				// 숫자 5개(1줄) 관리
	private boolean[] checked;		// 숫자의 상태를 체크할 변수
	
	
	// nums배열의 숫자를 설정하는데 겹치지 않게 설정.
	// 범위는 size의 두배수
	public LineBingo(int size) {
		nums = new int[size];
		checked = new boolean[size];
		
		// 앞에서 설정한 내용 복붙...
		int idx = 0;
		a : while(idx<nums.length) {
			int p = 1 + (int)(Math.random()*(size*2));
			
			// 같은 숫자라면 다시 설정
			for(int cnt=0; cnt<idx; cnt++) {
				if(nums[cnt] == p) {
					continue a;
				}
			}
			nums[idx++] = p;
		}
	}
	
	public LineBingo() {
		this(5);
	}
	
	// 부른 숫자가 있는지 체크
	// 있으면 checked true 설정
	public boolean mark(int data) {
		for(int i=0;i<nums.length;i++) {
			if(nums[i] == data) {
				checked[i] = true;
				return true;
			}
		}		
		return false;
	}
	
	// 자기가 가진 checked에 모든 값이 true인지 체크
	public boolean isRevealed() {
		for(int i=0;i<checked.length;i++) {
			if(checked[i] == false) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		String rep = "(";
		for(int i=0; i<nums.length;i++) {
			rep += (nums[i]<10 ? ("0"+ nums[i]) : nums[i]);
			if(i != nums.length-1) {
				rep += ", ";
			}
		}
		rep += ")";
		
		return rep;
	}
	
	
	public String toHiddenString() {
		String rep = "(";
		for(int i=0; i<nums.length;i++) {
			if(checked[i] == true) {
				rep += (nums[i]<10 ? ("0" +nums[i]) : nums[i]);
			}else {
				rep += "??";
			}
			if(i != nums.length-1) {
				rep += ", ";
			}
		}
		rep += ")";
		
		return rep;
	}
}
