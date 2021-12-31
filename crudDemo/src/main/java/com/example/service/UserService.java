package com.example.service;

import com.example.dao.UserDao;
import com.example.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public void add(User user){
        String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        user.setCreateTime(nowDate);
        userDao.save(user);
    }

    public void update(User user){
        String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        user.setCreateTime(nowDate);
        userDao.save(user);
    }

    public void deleteById(Long id){
        userDao.deleteById(id);
    }

    public User findById(Long id){
        Optional<User> user = userDao.findById(id);
        return userDao.findById(id).orElse(null);
    }


    public Page<User> findPage(Integer pageNum,Integer pageSize,String name){
        Sort sort =Sort.by(Sort.Direction.DESC,"create_time");
        PageRequest request = PageRequest.of(pageNum - 1, pageSize, sort);
        return userDao.findNameLike(name,request);
    }


}
