package org.koreait.models.member;

import lombok.RequiredArgsConstructor;
import org.koreait.commons.constants.Role;
import org.koreait.controllers.members.JoinForm;
import org.koreait.entities.Member;
import org.koreait.repositories.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/*
* 회원정보 추가 , 수정
* - 수정시 비밀번호는 값이 있을때만 수정
*/
@Service
@RequiredArgsConstructor
public class MemberSaveService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    public void save(JoinForm joinForm){

        Member member = new ModelMapper().map(joinForm , Member.class);
        member.setRoles(Role.USER);  // Role값은 디폴트값으로 넣어놨지만 혹시몰라서 한번 더 설정한다

        member.setUserPw(passwordEncoder.encode(joinForm.getUserPw()));

        memberRepository.saveAndFlush(member);

    }


}
