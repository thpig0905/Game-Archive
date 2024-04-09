function checkGender() {
    var gender = document.getElementById('gender').value;
    var submitBtn = document.getElementById('submitBtn');
    if (gender !== "") {
        submitBtn.disabled = false;
    } else {
        submitBtn.disabled = true;
    }
}

// 모달 창을 열고 닫는 함수
function openModal(modalId) {
    var modal = document.getElementById(modalId);
    modal.style.display = "block"; // 모달을 열 때 display 속성을 block으로 설정
    setTimeout(function() {
        modal.style.opacity = "1"; // 모달 창의 opacity를 1로 설정
    }, 50); // display 속성이 변경된 후에 opacity를 변경하도록 setTimeout 사용
}

function closeModal(modalId) {
    var modal = document.getElementById(modalId);
    modal.style.opacity = "0"; // 모달 창의 opacity를 0으로 설정
    setTimeout(function() {
        modal.style.display = "none"; // 모달 창의 display를 none으로 변경
    }, 1000);
}

// Sign in 버튼을 클릭하면 Sign in 모달 창이 열림
document.getElementById('signInButton').addEventListener('click', function(event) {
    event.preventDefault(); // 기본 동작(페이지 이동)을 막음
    openModal('signInModal');
});

// Sign up 버튼을 클릭하면 Sign up 모달 창이 열림
document.getElementById('signUpButton').addEventListener('click', function(event) {
    event.preventDefault(); // 기본 동작(페이지 이동)을 막음
    openModal('signUpModal');
});

window.onload = function() {
    setTimeout(function() {
        document.getElementById('logo').classList.add('show'); /* 페이지 로드 후 1초 후에 .show 클래스 추가 */
    }, 1000);
};

setTimeout(function() {
    document.getElementById('logo').classList.add('move-up');
    document.getElementById('buttons').classList.add('fade-in');
}, 2000);

document.querySelector('#signInModal form').addEventListener('submit', function(event) {
    var id = document.getElementById('id').value;
    var pw = document.getElementById('pw').value;

    if (id === "" || pw === "") {
        event.preventDefault(); // form 제출 막기
        openPopup(); // 팝업 띄우기
    }
});

document.querySelector('#signInModal form').addEventListener('submit', function(event) {
    var id = document.getElementById('signInId').value;
    var pw = document.getElementById('signInPw').value;

    if (id === "" || pw === "") {
        event.preventDefault(); // form 제출 막기
        openPopup('경고', 'ID와 PW를 모두 입력해주세요.'); // 팝업 띄우기
    }
});

document.querySelector('#signUpModal form').addEventListener('submit', function(event) {
    var id = document.getElementById('signUpId').value;
    var name = document.getElementById('name').value;
    var pw = document.getElementById('pw').value;
    var pwCheck = document.getElementById('pwCheck').value;
    var email = document.getElementById('email').value;
    var phone = document.getElementById('phone').value;
    var gender = document.getElementById('gender').value;

    if (id === "") {
        event.preventDefault();
        openPopup('경고', 'ID를 입력해주세요.');
    } else if (name === "") {
        event.preventDefault();
        openPopup('경고', '이름을 입력해주세요.');
    } else if (pw === "") {
        event.preventDefault();
        openPopup('경고', '비밀번호를 입력해주세요.');
    } else if (pwCheck === "") {
        event.preventDefault();
        openPopup('경고', '비밀번호 확인을 입력해주세요.');
    } else if (pw !== pwCheck) {
        event.preventDefault();
        openPopup('경고', '비밀번호와 비밀번호 확인이 일치하지 않습니다.');
    } else if (email === "") {
        event.preventDefault();
        openPopup('경고', '이메일을 입력해주세요.');
    } else if (phone === "") {
        event.preventDefault();
        openPopup('경고', '전화번호를 입력해주세요.');
    } else if (gender === "") {
        event.preventDefault();
        openPopup('경고', '성별을 선택해주세요.');
    }
});

function openPopup(title, message) {
    var popupTitle = document.getElementById('modal-title');
    var popupText = document.querySelector('#popup .text-sm');

    popupTitle.textContent = title;
    popupText.textContent = message;

    document.getElementById('popup').style.display = 'block';
}

function closePopup() {
    document.getElementById('popup').style.display = 'none';
}