/**
The MIT License (MIT) * Copyright (c) 2019 铭飞科技

 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package net.mingsoft.cms.biz.impl;

import net.mingsoft.basic.util.BasicUtil;
import net.mingsoft.cms.bean.ContentBean;
import net.mingsoft.mdiy.entity.ModelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.mingsoft.base.biz.impl.BaseBizImpl;
import net.mingsoft.base.dao.IBaseDao;
import java.util.*;
import net.mingsoft.cms.entity.ContentEntity;
import net.mingsoft.cms.biz.IContentBiz;
import net.mingsoft.cms.dao.IContentDao;

/**
 * 文章管理持久化层
 * @author 铭飞开发团队
 * 创建日期：2019-11-28 15:12:32<br/>
 * 历史修订：<br/>
 */
 @Service("cmscontentBizImpl")
public class ContentBizImpl extends BaseBizImpl implements IContentBiz {

	
	@Autowired
	private IContentDao contentDao;
	
	
	@Override
	protected IBaseDao getDao() {
		// TODO Auto-generated method stub
		return contentDao;
	}

	@Override
	public List<ContentBean> queryIdsByCategoryIdForParser(String categoryId, String beginTime, String endTime) {
		return this.contentDao.queryIdsByCategoryIdForParser(categoryId,BasicUtil.getAppId(), beginTime, endTime,null,null);
	}
	@Override
	public List<ContentBean> queryIdsByCategoryIdForParser(String categoryId, String beginTime, String endTime, String orderBy, String order) {
		return this.contentDao.queryIdsByCategoryIdForParser(categoryId, BasicUtil.getAppId(), beginTime, endTime,orderBy,order);
	}

	@Override
	public int getSearchCount(ModelEntity contentModel, List diyList, Map whereMap, int appId, String categoryIds) {
		if (contentModel!=null) {
			return contentDao.getSearchCount(contentModel.getModelTableName(),diyList,whereMap, appId,categoryIds);
		}
		return contentDao.getSearchCount(null,null,whereMap, appId,categoryIds);
	}
}