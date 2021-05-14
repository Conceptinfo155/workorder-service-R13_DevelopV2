package com.comcast.orion.workorder.utils.mapper;

import org.mapstruct.Named;

import com.comcast.orion.workorder.domain.sitev2.LineTagList;

public interface CommonMapper {
	
	@Named("mapBridgerAddress")
	default String mapBridgerAddress(com.comcast.orion.workorder.domain.sitev2.SiteResponse siteDetail) {
		String bridgerAddress = null;
		if (siteDetail != null && siteDetail.getBillingDetailsInfo() != null
				&& siteDetail.getBillingDetailsInfo().getCsgDetails() != null
				&& siteDetail.getBillingDetailsInfo().getCsgDetails().getBridgerAddress() != null
				&& (siteDetail.getBillingDetailsInfo().getCsgDetails().getBridgerAddress()
						.getBridgerBidirectional() != null
						|| siteDetail.getBillingDetailsInfo().getCsgDetails().getBridgerAddress()
								.getBridgerGateControl() != null
						|| siteDetail.getBillingDetailsInfo().getCsgDetails().getBridgerAddress()
								.getBridgerPrivate() != null)) {
			String emptyString = "";
			String bidirect = siteDetail.getBillingDetailsInfo().getCsgDetails().getBridgerAddress()
					.getBridgerBidirectional() == null ? emptyString
							: siteDetail.getBillingDetailsInfo().getCsgDetails().getBridgerAddress()
									.getBridgerBidirectional();
			String gateCtrl = siteDetail.getBillingDetailsInfo().getCsgDetails().getBridgerAddress()
					.getBridgerGateControl() == null ? emptyString
							: siteDetail.getBillingDetailsInfo().getCsgDetails().getBridgerAddress()
									.getBridgerGateControl();
			String pvt = siteDetail.getBillingDetailsInfo().getCsgDetails().getBridgerAddress()
					.getBridgerPrivate() == null ? emptyString
							: siteDetail.getBillingDetailsInfo().getCsgDetails().getBridgerAddress()
									.getBridgerPrivate();
			bridgerAddress = bidirect + gateCtrl + pvt;
		}
		return bridgerAddress;
	}
	
	@Named("mapDropTag1")
	default String mapDropTag1(com.comcast.orion.workorder.domain.sitev2.SiteResponse siteDetail){
		return mapDropTag("1",siteDetail);
	}
	
	@Named("mapDropTag2")
	default String mapDropTag2(com.comcast.orion.workorder.domain.sitev2.SiteResponse siteDetail){
		return mapDropTag("2",siteDetail);
	}
	
	@Named("mapDropTag3")
	default String mapDropTag3(com.comcast.orion.workorder.domain.sitev2.SiteResponse siteDetail){
		return mapDropTag("3",siteDetail);
	}

	default String mapDropTag(String index, com.comcast.orion.workorder.domain.sitev2.SiteResponse siteDetail) {
		if (siteDetail != null && siteDetail.getBillingDetailsInfo() != null
				&& siteDetail.getBillingDetailsInfo().getCsgDetails() != null
				&& siteDetail.getBillingDetailsInfo().getCsgDetails().getLineTagList() != null) {
			LineTagList lineTag = siteDetail.getBillingDetailsInfo().getCsgDetails().getLineTagList().stream()
					.filter(ltl -> ltl != null && ltl.getIndex().equals(index)).findFirst().orElse(null);
			if(lineTag != null) {
				return lineTag.getValue();
			}
		}
		return null;
	}

}
