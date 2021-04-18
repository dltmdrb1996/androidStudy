#### 안드로이드 스튜디오 Login template 분석
1. Activity -> ViewModel -> Repository -> Data 로 이어지는 정석적인 의존성 흐름
2. 모든 데이터의 처리가 viewmodel을 거친다 view는 리스너와 obersve를 통한 갱신 요청만을 실행 독립적이며 역의존성 제거
3. 
