package com.trkj.system.recruit_modular.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.system.recruit_modular.entity.Evaluate;
import com.trkj.system.recruit_modular.entity.InterviewVo;
import java.util.List;

/**
 * <p>
 * 面试表 服务类
 * </p>
 *
 * @author 鄧琪
 * @since 2022-01-12
 */
public interface InterviewServiceVo {
    /**
     * 简历列表分页查询：已邀约
     */
    IPage<InterviewVo> findAllInvite(InterviewVo interviewVo);
    /**
     * 分页查询出面试中的所有应聘人员信息
     * @return
     */
    IPage<InterviewVo> findall(InterviewVo interviewVo);

    /**
     * 分页查询出复试中的所有应聘人员信息
     * @return
     */
    IPage<InterviewVo> findallfs(InterviewVo interviewVo);

    /**
     * 分页查询出复面试通过的所有应聘人员信息
     * @return
     */
    IPage<InterviewVo> selectAlladopt(InterviewVo interviewVo);

    /**
     * 面试评论添加
     */
    int addmianspl(Evaluate evaluate);
    /**
     * 通过面试ID查询所有面试者的面试评论
     */
    List<Evaluate> findallpl(Evaluate evaluate);
    /**
     * 面试评论信息修改
     */
    int updatemapl(Evaluate evaluate);
    /**
     * 面试评论信息删除
     */
    int deletemapl(Integer id);
}
