package coders.mypage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import coders.common.common.CommandMap;
import coders.mypage.service.MypageService;

import org.springframework.web.bind.annotation.RequestMethod;

import java.net.http.HttpRequest;
import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MypageController {
	
	@Autowired
	private MypageService mypageService; 
	
	@RequestMapping(value = "/main/Mypage.do" )
	public ModelAndView mypage(HttpSession session,HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> mapor = new HashMap<String, Object>();
		String user_no = request.getParameter("USER_NO");
		Map<String, Object> smap = (Map<String, Object>)session.getAttribute("map");
		mav.setViewName("mypage/mypage");
		mapor.put("USER_NO", user_no);
		List<Map<String, Object>> flist = mypageService.selectFollowList(mapor);
		List<Map<String, Object>> slist = mypageService.selectScrapList(mapor);

		mav.addObject("flist",flist);
		mav.addObject("slist",slist);
		mav.addObject("USER_NO",user_no);
		
		if(smap !=null) {
			String suser_no = String.valueOf(smap.get("USER_NO"));
		if(user_no.equals(suser_no) ) {
			mav.addObject("CHECK","Y");
			return mav;}}
		mav.addObject("CHECK","N");
		return mav;
	}
	//유저 상세정보
	@RequestMapping(value = "/Mypage/MypageDetail.do")
	public ModelAndView mypageDetail(HttpServletRequest request,HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> mapor = new HashMap<String, Object>();
		String user_no = request.getParameter("USER_NO");
		Map<String, Object> smap = (Map<String, Object>)session.getAttribute("map");
		mapor.put("USER_NO", user_no);
		Map<String, Object> map = mypageService.selectMypageDetail(mapor);
		mav.addObject("map",map);
		mav.setViewName("/mypage/mypagedetail");
		mav.addObject("USER_NO",user_no);
		if(smap !=null) {
			String suser_no = String.valueOf(smap.get("USER_NO"));
		if(user_no.equals(suser_no) ) {
			mav.addObject("CHECK","Y");
			return mav;}}
		mav.addObject("CHECK","N");
		return mav;
	}
	//수정get
	@RequestMapping(value = "/Mypage/Modify.do",method = RequestMethod.GET)
public ModelAndView mypageModifyForm(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Map<String,Object> map = (Map<String, Object>)session.getAttribute("map");
		mav.addObject("map", map);
		mav.setViewName("/mypage/mypage_modify");
		return mav;
	
	}
	//수정post
	@RequestMapping(value = "/Mypage/Modify.do",method = RequestMethod.POST )
public ModelAndView mypageModify(HttpServletRequest request,CommandMap commandMap,HttpSession session)throws Exception {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map2  = (Map<String, Object>)session.getAttribute("map");
		Map<String, Object> map = new HashMap<String, Object>();
		commandMap.put("PROFILE", "test");
		commandMap.put("USER_NO", map2.get("USER_NO"));
		System.out.println(commandMap.get("PASSWORD"));
		System.out.println(commandMap.get("PASSWORD2"));
		if(!commandMap.get("PASSWORD").equals(commandMap.get("PASSWORD2"))) {
			mav.setViewName("redirect:/Mypage/Modify.do");
			mav.addObject("pas", "Y");
			return mav;
		}
		mypageService.updateMypage(commandMap.getMap());
		mav.setViewName("redirect:/main/Mypage.do?USER_NO="+map2.get("USER_NO"));
		return mav;
}
	//팔로우리스트
	@RequestMapping(value = "/Mypage/Follow.do")
public ModelAndView followList(HttpServletRequest request,HttpSession session) {
		Map<String, Object> mapor = new HashMap<String, Object>();
		Map<String, Object> smap = (Map<String, Object>)session.getAttribute("map");
		String user_no = request.getParameter("USER_NO");
		mapor.put("USER_NO", user_no);
		ModelAndView mav = new ModelAndView("/mypage/follow");
		mav.addObject("USER_NO",user_no);
		if(smap !=null) {
			String suser_no = String.valueOf(smap.get("USER_NO"));
		if(user_no.equals(suser_no) ) {
			mav.addObject("CHECK","Y");
			return mav;}}
		mav.addObject("CHECK","N");
		return mav;
}
	//프로젝트리스트
	@RequestMapping(value = "/Mypage/ProjectList.do")
public ModelAndView projectList(HttpServletRequest request,HttpSession session )throws Exception {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> mapor = new HashMap<String, Object>();
		Map<String, Object> smap = (Map<String, Object>)session.getAttribute("map");
		String user_no = request.getParameter("USER_NO");
		mapor.put("USER_NO", user_no);
		List<Map<String, Object>> list = mypageService.selectProjectList(mapor);
		mav.addObject("list",list);
		mav.setViewName("/mypage/myProject");
		mav.addObject("USER_NO",user_no);
		if(smap !=null) {
			String suser_no = String.valueOf(smap.get("USER_NO"));
		if(user_no.equals(suser_no) ) {
			mav.addObject("CHECK","Y");
			return mav;}}
		mav.addObject("CHECK","N");
		return mav;
}
	@RequestMapping(value = "/Mypage/WriteList.do")
public ModelAndView writeList(HttpServletRequest request,HttpSession session )throws Exception {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> mapor = new HashMap<String, Object>();
		Map<String, Object> smap = (Map<String, Object>)session.getAttribute("map");
		String user_no = request.getParameter("USER_NO");
		mapor.put("USER_NO",user_no );
		List<Map<String, Object>> list = mypageService.selectWriteList(mapor);
		mav.addObject("list",list);
		mav.setViewName("/mypage/myWrite");
		mav.addObject("USER_NO",user_no);
		if(smap !=null) {
			String suser_no = String.valueOf(smap.get("USER_NO"));
		if(user_no.equals(suser_no) ) {
			mav.addObject("CHECK","Y");
			return mav;}}
		mav.addObject("CHECK","N");
		return mav;
}
	@RequestMapping(value = "/Mypage/UserDelete.do")
public ModelAndView mypageDelete() {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> mapor = new HashMap<String, Object>();
		mapor.put("USER_NO", 1);
		mav.setViewName("redirect:/userDelete");
		return mav;
}
	@RequestMapping(value = "/Mypage/Notification.do")
public ModelAndView selectArlimeList(HttpSession session)throws Exception {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> mapor = (Map<String, Object>)session.getAttribute("map");
		List<Map<String, Object>> list1 = mypageService.selectArlimeList(mapor);
		List<Map<String, Object>> list2 = mypageService.selectProjetArList(mapor);
		mav.addObject("list1", list1);
		mav.addObject("list2", list2);
		mav.setViewName("/mypage/Notification");
		return mav;
}
	@RequestMapping(value = "/Mypage/ArlistClick.do")
	public ModelAndView clickArlist(HttpServletRequest request)throws Exception {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> mapor = new HashMap<String, Object>();
		String no = request.getParameter("BOARD_NO");
		 mapor.put("BOARD_NO", no); mypageService.clickArlist(mapor);
		mav.setViewName("redirect:/board/detail.do?BOARD_NO="+no);
		return mav;
		
	}
	@RequestMapping(value = "/Mypage/ProjectArClick.do")
	public ModelAndView clickProjectAr(HttpSession session,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> mapor = new HashMap<String, Object>();
		String no = request.getParameter("PROJECT_NO");
		mapor.put("USER_NO", 1);
		mapor.put("PROJECT_NO", no);
		mav.setViewName("redirect:/Project/Team.do?PROJECT_NO="+no);
		return mav;
		
	}

}
