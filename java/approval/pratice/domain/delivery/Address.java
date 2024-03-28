package approval.pratice.domain.delivery;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    /*
    @Embeddable은 자바 기본 생성자를public 또는 protected로 설정해야한다.
    JPA구현 라이브러리가 개체를 생성할 떄 리플랙션 같은 기술을 사용할 수 있도록 지원해야하 하기 때문
    */
    protected Address() {

    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

}
