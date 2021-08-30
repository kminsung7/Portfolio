const nextBtns = document.querySelectorAll(".next_btn"); //버튼 전부 다
const todoList = document.querySelector("#todo"); 
const doingList = document.querySelector("#doing");
const doneList = document.querySelector("#done");    
const httpRequest = new XMLHttpRequest();

function typeChange(clickedBtn){ // 타입 바뀔때 프론트 엔드 바뀌는 모습
    const li = clickedBtn.target.parentElement; //버튼 클릭된 부모 노트 li
    const type = li.parentElement.previousElementSibling.innerText; 
    
    if(type === "TODO"){
        doingList.appendChild(li); // 자식 요소 중 마지막 위치로
    }else{
        clickedBtn.target.remove();
        doneList.appendChild(li); 
    }
}

function getType(clickedBtn) { //type 유형 반환
    const type = clickedBtn.target.parentElement.parentElement.previousElementSibling.innerText; //type 유형
    return type;
}

function getId(clickedBtn) { //id 반환
    const id = clickedBtn.target.nextElementSibling.textContent;
	return id;
}

function ajaxRequest(clickedBtn) { //ajax (비동기)처리를 위한 함수
    const type = getType(clickedBtn); //나중에 post 방식으로 값 전달하기 위함
	const id = getId(clickedBtn); //나중에 post 방식으로 값 전달하기 위함
    
    if(!httpRequest) {
        alert('XMLHTTP 인스턴스를 만들 수가 없습니다.');
        return false;
    }
    httpRequest.onreadystatechange = function () { //ajax 통신으로 응답 받은 결과를 실행 하는 함수
        if (httpRequest.readyState === XMLHttpRequest.DONE) {
            if (httpRequest.status === 200) {
                console.log(httpRequest.responseText); //서버로 부터 받은 응답을 처리함.
                typeChange(clickedBtn);
            } else {
                alert('request에 뭔가 문제가 있어요.');
            }
        }
    }; // 서버 상태 준비 완료시 excute 함수 실행
    httpRequest.open('POST', 'http://localhost:8000/type'); // post방식으로 일단 서버 통로 생성 
    httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); // post 타입으로 보내기 때문에 설정해줌
    httpRequest.send("type="+encodeURIComponent(type)+"&id="+encodeURIComponent(id)); // 실제 데이터를 보냄, 보내는 데이터를 인코딩하여 보내줌
}


for(const nextBtn of nextBtns) { // for of 구문으로 모든 버튼에 대해 두가지 함수를 실행하는 이벤트리스너 등록
    nextBtn.addEventListener("click", ajaxRequest);
}