/*
 * Copyright (c) 2012. The Genome Analysis Centre, Norwich, UK
 * MISO project contacts: Robert Davey, Mario Caccamo @ TGAC
 * *********************************************************************
 *
 * This file is part of MISO.
 *
 * MISO is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MISO is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MISO.  If not, see <http://www.gnu.org/licenses/>.
 *
 * *********************************************************************
 */

package uk.ac.bbsrc.tgac.miso.core.event.impl;

import org.aspectj.lang.annotation.Aspect;
import uk.ac.bbsrc.tgac.miso.core.event.manager.PoolAlertManager;
import uk.ac.bbsrc.tgac.miso.core.event.manager.ProjectAlertManager;
import uk.ac.bbsrc.tgac.miso.core.event.manager.RunAlertManager;

import java.io.IOException;

/**
 * uk.ac.bbsrc.tgac.miso.core.event
 * <p/>
 * Info
 *
 * @author Rob Davey
 * @date 11/01/12
 * @since 0.1.4
 */
@Aspect
public class UserUpdateAspect {
  private ProjectAlertManager projectAlertManager;
  private RunAlertManager runAlertManager;
  private PoolAlertManager poolAlertManager;

  public void setProjectAlertManager(ProjectAlertManager projectAlertManager) {
    this.projectAlertManager = projectAlertManager;
  }

  public void setRunAlertManager(RunAlertManager runAlertManager) {
    this.runAlertManager = runAlertManager;
  }

  public void setPoolAlertManager(PoolAlertManager poolAlertManager) {
    this.poolAlertManager = poolAlertManager;
  }

  public void update(Long userId) {
    try {
      runAlertManager.updateGroupWatcher(userId);
      projectAlertManager.updateGroupWatcher(userId);
      poolAlertManager.updateGroupWatcher(userId);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}
