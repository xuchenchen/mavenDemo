package com.ryx.service.imp;

import com.ryx.generratorpojo.Teacher;
import com.ryx.generratorpojo.TeacherExample;
import com.ryx.generratorpojo.TeacherMapper;
import com.ryx.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("TeacherServiceImpl")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    public TeacherMapper teacherMapper;

    @Override
    public int countByExample(TeacherExample example) {
        return teacherMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(TeacherExample example) {
        return teacherMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer tId) {
        return teacherMapper.deleteByPrimaryKey(tId);
    }

    @Override
    public int insert(Teacher record) {
        return teacherMapper.insert(record);
    }

    @Override
    public int insertSelective(Teacher record) {
        return teacherMapper.insertSelective(record);
    }

    @Override
    public List<Teacher> selectByExample(TeacherExample example) {
        return teacherMapper.selectByExample(example);
    }

    @Override
    public Teacher selectByPrimaryKey(Integer tId) {

        return teacherMapper.selectByPrimaryKey(tId);
    }

    @Override
    public int updateByExampleSelective(Teacher record, TeacherExample example) {
        return teacherMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Teacher record, TeacherExample example) {
        return teacherMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Teacher record) {
        return teacherMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Teacher record) {
        return teacherMapper.updateByPrimaryKey(record);
    }
}
