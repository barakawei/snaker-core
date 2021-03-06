/* Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.snaker.engine.access.dialect;

/**
 * Postgresql数据库方言实现
 * @author yuqs
 * @since 1.3
 */
public class PostgresqlDialect implements Dialect {
	/**
	 * Postgresql分页通过limit实现
	 */
	public String getPageSql(String sql, int pageNo, int pageSize) {
		StringBuffer pageSql = new StringBuffer(sql.length() + 100);
		pageSql.append(getPageBefore(pageNo, pageSize));
		pageSql.append(sql);
		pageSql.append(getPageAfter(pageNo, pageSize));
		return pageSql.toString();
	}

	
	public String getPageBefore(int pageNo, int pageSize) {
		return "";
	}

	public String getPageAfter(int pageNo, int pageSize) {
		long start = (pageNo - 1) * pageSize;
		StringBuffer sb = new StringBuffer();
		sb.append(" limit ").append(pageSize).append(" offset ").append(start);
		return sb.toString();
	}
}
