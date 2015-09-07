package com.example.plugins.service.impl;

import com.example.plugins.service.base.PartsLocalServiceBaseImpl;

/**
 * The implementation of the parts local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.example.plugins.service.PartsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.example.plugins.service.base.PartsLocalServiceBaseImpl
 * @see com.example.plugins.service.PartsLocalServiceUtil
 */
public class PartsLocalServiceImpl extends PartsLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.example.plugins.service.PartsLocalServiceUtil} to access the parts local service.
     */
	
	public void displayServiceName(){
		System.out.println("");
		
	}
}
