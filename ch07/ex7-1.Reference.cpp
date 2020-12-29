// 로드값 배리어

struct Reference {
  unsigned inPageVA : 21;	//  0-20비트
  unsigned PageNumber: 21;	// 21-41비트
  unsigned NMT : 1;		//    42비트
  unsigned SpaceID : 2;		// 43-44비트
  unsigned unused : 19;		// 45-63비트
};

int Expeted_NMT_Value[4] = {0, 0, 0, 0};

// 공간 ID값
// 00 NULL 및 논힙 포인터
// 01 올드 세대 레퍼런스
// 02 뉴 세대 레퍼런스
// 11 사용 안 함
