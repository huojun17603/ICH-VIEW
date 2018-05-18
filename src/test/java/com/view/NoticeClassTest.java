package com.view;

import com.ich.core.base.ObjectHelper;
import com.ich.core.http.entity.HttpResponse;
import com.ich.core.http.entity.PageView;
import com.ich.view.pojo.Notice;
import com.ich.view.pojo.NoticeClass;
import com.ich.view.pojo.NoticeReview;
import com.ich.view.pojo.NoticeReviewReply;
import com.ich.view.service.*;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class NoticeClassTest extends BaseJunit4Test {

    @Resource  //自动注入,默认按名称
    private NoticeReviewService noticeReviewService;
    @Resource  //自动注入,默认按名称
    private NoticeReviewReplyService noticeReviewReplyService;
    @Resource
    private NoticeHelpService noticeHelpService;
    @Resource
    private NoticeService noticeService;

    @Test   //标明是测试方法
    @Transactional   //标明此方法需使用事务
    @Rollback(true)  //标明使用完此方法后事务不回滚,true时为回滚
    public void insert() {
//        NoticeReview review = new NoticeReview();
//        review.setSource(1);
//        review.setSourceid("1");
//        review.setUserid("1");
//        review.setContent("XXXXXXXXXX");
//        noticeReviewService.addReview(review);
    }
//
//    @Test   //标明是测试方法
//    @Transactional   //标明此方法需使用事务
//    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚
//    public void insertReply() {
//        List<NoticeReview> list = noticeReviewService.queryReviewList(new PageView(),1,"1");
//        for(NoticeReview reviews : list){
//            NoticeReviewReply review = new NoticeReviewReply();
//            review.setReviewid(reviews.getId());
//            review.setUserid("1");
//            review.setContent("XXXXXXXXXX");
//            noticeReviewReplyService.addReply(review);
//        }
//    }
//
//    @Test   //标明是测试方法
//    @Transactional   //标明此方法需使用事务
//    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚
//    public void delReply() {
//        //noticeReviewReplyService.delReply("058a799947d4449f8958da7b8f884646");
//        List<NoticeReview> list = noticeReviewService.queryReviewList(new PageView(),1,"1");
//        if(list.size()>0)
//            noticeReviewService.delReview(list.get(0).getId());
//    }

}
