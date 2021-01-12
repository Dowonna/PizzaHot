# :pizza: PizzaHot

PizzaHot은 가게의 위치, 판매중인 메뉴안내 및 예약기능이 가능한 홈페이지입니다.

<img src = "https://github.com/Ta-Ye/PizzaHot/blob/main/WebContent/images/pizza_home.jpg" width="70%">

## Intruduction
- 이탈리아 음식으로 유명한 "Pizza"! 한국에서도 대표적인 술안주로 자리매김하게 되면서 많은 피자가게가 오픈되었습니다.
- "PizzaHot"은 피자전문 레스토랑을 컨셉으로 한 음식점이 오픈되었다는 가정하에, 가게 홍보를 위한 홈페이지 제작을 시작하게 되었습니다.
- 홈페이지에는 판매메뉴 및 위치안내 그리고 온라인 예약시스템 구현을 목표로 하였습니다.

## :eyes: Structure
<img src = "https://user-images.githubusercontent.com/72329183/103186507-17078e00-4904-11eb-950b-395b6766f0c8.PNG" width="70%">

## :hammer_and_wrench: Service Process
<img src = "https://user-images.githubusercontent.com/72329183/103187885-892ea180-4909-11eb-8b38-70907afca962.PNG" width="70%">

| :closed_lock_with_key: 관리자 | :family: 회원 |
|------|---|
|- 메뉴 관리 (추가, 삭제, 업데이트, 확인) <br> - 예약자 관리 |   - 메뉴 확인 <br> - 예약 메뉴 선택 <br> - 예약 일자 선택 후 안내 문자 받기(Telegram) |



## 💡 Technologies Used
<!--<img src = "https://i.imgur.com/0D3JHvS.jpg" width="70%">-->

| :back: Back-End | :globe_with_meridians: Front-End | :package: Config |
|------|---|---|
|![tomcat](https://img.shields.io/badge/Apache%20Tomcat-v8.5.61-yellow) ![eslint](https://img.shields.io/badge/ESLint-v7.17.0-purple) ![](https://img.shields.io/badge/Oracle%20DB-SE-red) ![](https://img.shields.io/badge/JPA-v2.1-yellow) | ![Servlet](https://img.shields.io/badge/Servlet-v3.1-red) ![JSP](https://img.shields.io/badge/JSP-v2.3-red) ![node-red](https://img.shields.io/badge/Node--RED-v1.2-red)|![Github](https://img.shields.io/badge/Github-Git%20bash-lightgrey)|

## 🤖 ChatBot
  - 예약 정보를 Node-Red와 Telegram 연동해서 보냈습니다.
  - 전체 플로우 구성은 다음과 같다.
  ![OverallFlow](https://user-images.githubusercontent.com/58159833/103186112-972cf400-4902-11eb-95e5-22bfbf89a0be.PNG)

## :movie_camera: Feature
| Asynchronous |
|------|
| <img src = "https://i.imgur.com/Iq1q4JL.gif"> | 

| Menu | About |
|:------:|:------:|
| <img src = "https://i.imgur.com/qgkRdDG.gif"> | <img src = "https://i.imgur.com/OoMWInA.gif"> |
| Reservation | Send Telegram |
| <img src = "https://i.imgur.com/aU1JjsN.gif"> | <img src = "https://i.imgur.com/WEtK8Ny.gif"> |
| Confirm Reservation | CRUD Menu |
| <img src = "https://i.imgur.com/iOdcuxf.gif"> | <img src = "https://i.imgur.com/2mKp5AV.gif"> |

## :running: TensorFlow

| Order & Cancellation | Order & Reservation |
|:------:|:------:|
| <img src = "https://i.imgur.com/DUTOemf.gif"> | <img src = "https://i.imgur.com/Wp9nlLt.gif"> |


## ✍️ Author
 
| <img src = "https://github.com/Ta-Ye/PizzaHot/blob/main/WebContent/images/TY.PNG"> | <img src = "https://github.com/Ta-Ye/PizzaHot/blob/main/WebContent/images/MG.PNG"> | <img src = "https://github.com/Ta-Ye/PizzaHot/blob/main/WebContent/images/CH.PNG">  |
|:---:|:---:|:---:|
|:dancers: **최태열** <a href="https://github.com/ta-ye">Taeyeol Choi</a> | :gun: **김민건** <a href="https://github.com/alsrjs2441">Mingeon Kim</a> | :vhs: **김창훈** <a href="https://github.com/bbiku">Changhun Kim</a> |


  
## 🔥 Issues
  - 장바구니와 메세지 보내는 로직을 같이 구현하는 과정에서 이름과 전화번호를 통한 비회원 로그인를 목표로 했습니다.
    여기서 동시 접속자에 관해서 테이블이 겹칠 수 있다는 것을 발견했습니다. 
    차후 자바스크립트를 배우고 chatbot을 node-red가 아닌 이클립스에서 구현하여 서버를 동일하게 해준다면 문제 해결이 가능할 것 같습니다.
  
## 참고
테이블 내부 구성 엑셀 문서 링크

https://docs.google.com/spreadsheets/d/1AU1l4ZkSYovK2h-uNDyUG6OUr7KVe04iYpt-N93Nw0s/edit#gid=0

데이터모델링 링크

https://www.erdcloud.com/d/ShDGTzo6H7Wahipuf
