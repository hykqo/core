package hello.core.singleton;

//객체를 미리 생성해두는 가장 단순하고 안전한 방법
public class SingletonService {

    //static으로 지정하면 클래스 레벨에 올라기기 때문에 딱 한개만 존재하게 된다.
    private static final SingletonService instance = new SingletonService();

    //public으로 열어서 객체 인스턴스가 필요하면 이 statuc 메소드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance(){
        return instance;
    }

    //생성자를 private으로 선언해서 외부에서 New 키워드를 사용한 객체 생성을 못하게 막는다.
    private  SingletonService(){
    }

    public void Logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}

