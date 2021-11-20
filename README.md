# equals()와 hashCode()

- ### equals()

``` text
equals()는 보통 동일한 객체인지 확인할 때 사용합니다 (객체 인스턴스의 주소 값)
또는 String의 경우는 문자열이 동등한지 확인할 때 사용합니다
String class는 equals() 메소드를 재정의해서 주소 값 비교가 아닌 문자열 값을 비교합니다
```

``` java
// Object 
public boolean equals(Object obj) {
    return (this == obj);
}

// String class 
public boolean equals(Object anObject) {
    if (this == anObject) {
        return true;
    }
    if (anObject instanceof String) {
        String anotherString = (String)anObject;
        int n = value.length;
        if (n == anotherString.value.length) {
            char v1[] = value;
            char v2[] = anotherString.value;
            int i = 0;
            while (n-- != 0) {
                if (v1[i] != v2[i])
                    return false;
                i++;
            }
            return true;
        }
    }
    return false;
}
```

---

<br>

- ### hashCode()

``` text
hashCode()는 객체의 주소 값을 이용해서 해시코드를 만들어서 리턴한다
객체의 값을 동등성 비교시 hashCode()를 오버라이딩할 필요성이 있고 
대표적인 예로 컬렉션 프레임워크에서 HashSet, HashMap, HashTable은 두 객체가 동등한지 비교한다
```

``` java
// Object 
public native int hashCode();
```

---

<br>

- ### equals()와 hashCode()의 관계

``` text
hashCode() 메소드를 실행해서 리턴된 해시코드 값이 같은지를 본다
해시 코드값이 다르면 다른 객체로 판단하고, 
해시 코드값이 같으면 equals() 메소드로 다시 비교한다
이 두 개가 모두 맞아야 동등 객체로 판단한다
즉, 해시코드 값이 다른 엔트리끼리는 동치성 비교를 시도조차 하지 않는다

그렇기 때문에 equals()를 재정의 할 때는 hashCode()도 재정의해야 한다
equals()의 값이 true면 hashCode()도 동일한 값을 가져야하고
반대로 equals() 값이 false이면, hashCode()도 다른 값을 가져야 한다
```