package com.nsdciot.system.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.nsdciot.system.vo.UserVO;
import org.springframework.stereotype.Service;

import com.nsdciot.common.domain.Tree;
import com.nsdciot.system.domain.DeptDO;
import com.nsdciot.system.domain.UserDO;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface SysUserService {
	UserDO get(Long id);

	List<UserDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(UserDO user);

	int update(UserDO user);

	int remove(Long userId);

	int batchremove(Long[] userIds);

	boolean exit(Map<String, Object> params);

	Set<String> listRoles(Long userId);

	int resetPwd(UserVO userVO,UserDO userDO) throws Exception;
	int adminResetPwd(UserVO userVO) throws Exception;
	Tree<DeptDO> getTree();

	/**
	 * 更新个人信息
	 * @param userDO
	 * @return
	 */
	int updatePersonal(UserDO userDO);

	/**
	 * 更新个人图片
	 * @param file 图片
	 * @param avatar_data 裁剪信息
	 * @param userId 用户ID
	 * @throws Exception
	 */
    Map<String, Object> updatePersonalImg(MultipartFile file, String avatar_data, Long userId) throws Exception;
}
