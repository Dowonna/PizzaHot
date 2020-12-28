# JSP MiniProject

## :pizza: PizzaHot

매장 소개와 예약을 동시에 수행하는 PizzaHot 홈페이지

손님은 홈페이지에서 예약을 하고

관리자는 메뉴 관리와 예약 관리를 할 수 있다.

## Intruduction
- :raising_hand: :ok_woman: 마트의 민족은 앱이나 웹으로 원하는 물건을 주문하면 직접 고객이 인근 마트에서 구매했었던 상품들을 찾아가는 JPA로 구현한 서비스입니다.
- 이탈리아 음식으로 유명한 "Pizza"! 한국에서도 대표적인 술안주로 자리매김하게 되면서 많은 피자가게가 오픈되었습니다.
- "PizzaHot"은 피자전문 레스토랑을 컨셉으로 한 음식점이 오픈되었다는 가정하에, 가게 홍보를 위한 홈페이지 제작을 시작하게 되었습니다.
- 홈페이지에는 판매메뉴 및 위치안내 그리고 온라인 예약시스템 구현을 목표로 하였습니다.

## :eyes: Structure
![ERD](https://user-images.githubusercontent.com/72329183/103186507-17078e00-4904-11eb-950b-395b6766f0c8.PNG)

## :hammer_and_wrench: Service Process
![Slide1](https://user-images.githubusercontent.com/37354978/102005472-5ce92180-3d5c-11eb-8e75-327304f69ee7.jpg)
:closed_lock_with_key: 관리자
  - 메뉴 관리 (추가, 삭제, 업데이트, 확인)
  - 예약자 관리

:family: 회원
  - 메뉴 확인
  - 예약 메뉴 선택
  - 예약 일자 선택 후 안내 문자 받기(Telegram)

## 💡 Technologies Used
![new page1](https://user-images.githubusercontent.com/37354978/102030120-ba30b180-3df4-11eb-960a-26c82137cfe3.JPG)

## 🌊 Data Flow

### MVC Model Architecture

![데이터흐름도2](https://user-images.githubusercontent.com/37354978/102006703-7e4f0b00-3d66-11eb-81c3-690095433932.JPG)


## ✍️ Author
 Team PeopelOfMarket
  - 최태열 [(Taeyeol Choi)](https://github.com/ta-ye)
  - 김민건 [(Mingeon Kim)](https://github.com/alsrjs2441)
  - 김창훈 [(Changhun kim)](https://github.com/bbiku)
  
## 🔥 Issues
  - 프론트엔드가 없어서 화면을 구현하기 어려웠다. 따라서 node-red를 사용하게 되었다.
  - 임의로 data를 구현하여 OrcleDB에 저장하는 과정을 진행했기 때문에 실제 서비스에서의 과정과는 다소 달랐다.
  
  - 추후 프론트엔드 부분도 구현하여 전체적인 프로젝트를 완성해야할 필요성을 느끼게 되었다.
  
## 🤖 ChatBot
  - 예약 정보를 Node-Red를 통해 Telegram 연동해서 보냈다.
  - 전체 플로우 구성은 다음과 같다.
  ![OverallFlow](https://user-images.githubusercontent.com/58159833/103186112-972cf400-4902-11eb-95e5-22bfbf89a0be.PNG)
  
## 참고
테이블 내부 구성 엑셀 문서 링크

https://docs.google.com/spreadsheets/d/1tmYgHqzKEgwfonAy3ZgYwQT_1SNpU3c6bemWXRXWOFw/edit#gid=0

데이터모델링 링크

https://www.erdcloud.com/d/ShDGTzo6H7Wahipuf
