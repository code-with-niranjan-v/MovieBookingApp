package com.example.demo.Service;

import com.example.demo.Entity.Booking;
import com.example.demo.Entity.Member;
import com.example.demo.Repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepo memberRepo;

    public Member addMember(Member m){
        return memberRepo.save(m);
    }

    public List<Member> getAllMember(){
        return memberRepo.findAll();
    }

    public Member getMemberById(int id) {
        return memberRepo.findById(id).orElse(null);
    }

    public Member updateMember(Member m) {
        return memberRepo.save(m);
    }

    public String deleteMemberById(int id) {
        Member m = getMemberById(id);
        if(m!=null){
            memberRepo.delete(m);
            return "Member Deleted!";
        }else{
            return "Member Not Found!";
        }
    }

    public String calculateBill(int id) {
        Member m = getMemberById(id);
        if(m!=null){
            double bill = 0;
            if(m.getBookings()!=null){
                for(Booking b:m.getBookings()){
                    bill += b.getTotalAmount();
                }
            }
            return "The bill is "+bill+".";

        }else {
            return "Member not Found!";
        }
    }
}
