/*
 ************************************************************************************
 * Copyright (C) 2001-2009 encuestame: system online surveys Copyright (C) 2009
 * encuestame Development Team.
 * Licensed under the Apache Software License version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to  in writing,  software  distributed
 * under the License is distributed  on  an  "AS IS"  BASIS,  WITHOUT  WARRANTIES  OR
 * CONDITIONS OF ANY KIND, either  express  or  implied.  See  the  License  for  the
 * specific language governing permissions and limitations under the License.
 ************************************************************************************
 */
package org.encuestame.core.service;

import java.util.Collection;
import org.encuestame.core.exception.EnMeExpcetion;
import org.encuestame.core.persistence.pojo.Project;
import org.encuestame.utils.web.UnitProjectBean;

/**
 * Project Service Interface.
 * @author Morales, Diana Paola paola@encuestame.org
 * @since April 13, 2009
 * @version $Id: $
 */
public interface IProjectService {

    /**
     * Load List of Project.
     * @param userId user id
     * @return {@link Collection} of {@link UnitProjectBean}
     * @throws EnMeExpcetion exception
     */
    Collection<UnitProjectBean> loadListProjects(final Long userId) throws EnMeExpcetion ;

    /**
     * Load project info.
     * @param project {@link Project}
     * @return {@link UnitProjectBean}
     * @throws EnMeExpcetion excepcion
     */
    UnitProjectBean loadProjectInfo(UnitProjectBean project) throws EnMeExpcetion;

    /**
     * create project.
     *
     * @param projectBean {@link UnitProjectBean}
     * @return {@link UnitProjectBean}
     * @throws EnMeExpcetion exception
     */
    UnitProjectBean createProject(UnitProjectBean projectBean) throws EnMeExpcetion;

}