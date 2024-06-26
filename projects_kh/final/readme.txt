폴더 및 파일 설명

db : MySQL DDL과 DML 파일이 있는 폴더입니다
ppt : 프로젝트 발표에 사용된 ppt 파일이 있는 폴더입니다.
filnal_project : 프로젝트 결과물이 있는 폴더입니다.


팀명: 스터디 모임 프로젝트

조원 별 구현 내용

- 이승주(팀장): 기본 틀 작업(header, footer, baseLayout), 그룹모집 상세보기, 강의 페이지(리스트, 상세보기, 등록, 수정), 강의 결제
- 강인서: 일반 회원가입, (회원가입 시)상세정보 입력, 그룹홈(가입한 그룹 리스트 조회, 그룹홈 조회, DDAY 출력, 일정 추가 및 삭제, 최근 그룹 게시글 조회, 그룹 게시판 게시글 작성/수정/삭제, 그룹 멤버 경고 부여 및 강제탈퇴, 그룹 정보 수정, 그룹 지원서 관리, 상호평가, 그룹 탈퇴, 그룹 활동 보존하기(수정 불가 상태로 만들기), 그룹 리더 변경), UI 프로토타이핑(관리자 멘토 권한 관리, 관리자 게시판 관리, 그룹홈 일체)
- 박성훈: (회원가입 시) 이메일 인증, 아이디 찾기, 비밀번호 찾기, (비밀번호 찾기 시) 이메일 인증, 일반 로그인, 자동로그인, 로그인 5회 실패 시 계정 임시정지,  sns 로그인(카카오 api), (일반 회원가입+sns회원가입 시) 다음 주소 api를 이용한 주소 입력, 멘토신청, 멘토 관리 페이지(멘토신청내역 조회, 멘토 신청 허가, 멘토 신청 거절), 멘토링 등록,  게시판 관리 페이지(게시판 조회, 게시판 등록, 게시판 수정, 게시판 삭제), ajax URL에 직접 접근을 제한하기 위한 AjaxInterceptor, 유저의 상태 혹은 권한에 따른 사이트 이용을 제한하기 위한 MemberInterceptor, AdminInterceptor, 에러페이지 처리
- 손나영: 메인페이지(추천 순 정렬 및 출력), 스터디/프로젝트 페이지(리스트 화면 조회 출력, 글 신고 기능), 멘토링 페이지(조회, 멘토링 상세 조회(검색어 및 직무별 조회 기능), 멘토링 상세화면, 멘토링 신청 화면 및 신청기능, 멘토링 수정 삭제, 신고 기능), 관리자 페이지(신고관리-신고조회(신고 대상별, 처리여부별), 신고 처리 기능(개별, 일괄), 멤버관리-멤버 조회, 멤버검색, 멤버 권한 및 상태 변경 기능)
- 심아진:  그룹 생성 기능, 스터디/프로젝트 공고 지원 화면 및 지원 기능, 마이페이지 그룹 프로젝트 (상호평가, 내가 생성한 그룹, 내가 지원한 그룹, 멘토링 리스트 띄우기), 스터디/프로젝트 지원서 상세 조회 및 수정 기능, 스터디/프로젝트 공고 추천 기능, 멘토링 지원서 상세 조회 및 수정 기능, 멘토링 추천 기능, 멘토링 지원서 상세 조회 및 수정 기능, 멘토링 공고 상세 조회

개요

- ‘스터디 모임(약칭 SMO)’는 IT 업계 구직자들을 대상으로 각종 편의 기능을 제공하기 위해 개발된 웹 플랫폼
- 주요 기능으로는 스터디/프로젝트 구인, 스터디/프로젝트 그룹홈, 멘토링 하기/받기, 강의 판매/구매 등이 있음.

구현 기능

- 일반 회원: 회원가입, 로그인, 그룹 가입 신청, 그룹 게시글 작성/수정/삭제, 그룹 일정 추가/삭제, 그룹 생성, 그룹 탈퇴, 그룹 정보 관리, 그룹 멤버 상호평가, 그룹 지원자 관리, 그룹 멤버 관리
- 멘토 회원: 멘토링 글 등록 및 멘티 신청서 확인, 강의 등록/수정/삭제
- 관리자: 회원관리(조회, 상태변경, 삭제), 멘토 관리(멘토 수락/거절), 신고 관리(조회. 처리)

설계의 주안점

- 팀 프로젝트를 모집, 시작, 진행, 기록 저장, 포트폴리오화 등을 하는 데 있어 유용한 도구가 되도록 함

사용 기술 및 개발 환경

- 운영체제: Window 10
- 언어: JAVA, JS, HTML, CSS, SQL
- 프레임 워크: Spring
- 협업 도구: Figma, Notion, Git
- 툴: MySQL, STS
- 라이브러리: FullCalendar, BS4, jQuery, Ajax, Mybatis, Apache
