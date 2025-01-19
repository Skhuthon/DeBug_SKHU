# ❓기획 의도 및 개요
* 여름에 급증하는 벌레가 떠올라 `벌레를 대신 처리해주는 버그 헌터 서비스` 기획
* 근처 지역 내에서 헌터 구인 글이 지도로 공유가 되므로 벌레 잡아주기를 원하는 사람들은 빠르고 쉽게 벌레를 퇴치
* 버그헌터들은 수익을 얻으면서 헌터랭킹에 올라가 적극 참여

# 🖥️메인 페이지
* 크게 헌터구인, 헌팅하기, 헌터랭킹 페이지로 구분
<img src="https://github.com/user-attachments/assets/477bc61d-49fe-4f3e-8cd5-783e1a76fee9" width="50%" />

# ✅기능 소개
### 로그인
<img src="https://github.com/user-attachments/assets/2a80cf78-8524-4181-b548-8212ef10c905" width="50%" />

### 버그 헌터 구인하기
* Google Map API 활용하여 개발
* 본인 위치를 선택하고 벌레의 정보(크기, 마리 수 등)를 적어 저장하면 지도위에 해당 위치에 마크업
<img src="https://github.com/user-attachments/assets/46ed530b-89dc-4d06-b48e-a5636fba1b7d" width="50%" />

### 버그 헌팅하기
* 지도에서 실시간으로 주변 버그헌터요청의 마크업 표시가 조회
* 각 요청에서 벌레의 정보를 확인한 후 해당 요청에 대한 수락여부를 결정
* 수락여부는 헌터가 요청 수락 시 구인글을 올린 작성자에게도 표시
<img src="https://github.com/user-attachments/assets/9da719e4-a273-4cd9-8efd-e5fb0d04629b" width="50%" />

### 버그 헌팅 랭킹
* 벌레를 잡은 횟수에 따라 순위가 결정
<img src="https://github.com/user-attachments/assets/09e49999-c1d7-4928-a717-032410b07b75" width="50%" />

# 개발 아키텍쳐
<img src="https://github.com/user-attachments/assets/7d774214-6565-4f36-a31a-226fd38ceaa3" width="50%" />
