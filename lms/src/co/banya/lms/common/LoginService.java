package co.banya.lms.common;

public interface LoginService<T> {	// 로그인 정보 받아와야 하니까 generic type으로 선언
	// 상위 인터페이스니까 public으로 만들어야 함.
	public T login(T vo);
}
