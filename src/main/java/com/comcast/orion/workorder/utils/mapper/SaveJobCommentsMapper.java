package com.comcast.orion.workorder.utils.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.comcast.orion.workorder.domain.createwo.CreateWORequest;
import com.comcast.orion.workorder.domain.createwo.CreateWorkorderRequest;
import com.comcast.orion.workorder.domain.createwo.CreateWorkorderResponse;
import com.comcast.orion.workorder.domain.saveNotes.FieldsList;
import com.comcast.orion.workorder.domain.saveNotes.SaveNoteRequest;
import com.comcast.orion.workorder.domain.saveNotes.SaveRequest;

/**
 * SaveJobCommentsMapper
 *
 */
@Mapper(componentModel = "spring")
public interface SaveJobCommentsMapper {

	/**
	 * @param source 
	 * @param workOrderNum
	 * @return
	 */
	@Mapping(target = "createdBy", source = "source")
	@Mapping(target = "noteType", source = "jobComments")
	SaveNoteRequest getRequest(String jobComments, String source);
	
	/**
	 * @param createWorkorderRequest
	 * @param workOrderNum
	 * @param jobComments 
	 * @param source 
	 * @return
	 */
	default SaveRequest getSaveNotesRequest(CreateWorkorderRequest createWorkorderRequest, String workOrderNum,
			String jobComments, String source) {
		SaveRequest saveRequest = new SaveRequest();
		SaveNoteRequest saveNoteRequest = getRequest(jobComments, source);
		FieldsList attributeList = new FieldsList();
		if (createWorkorderRequest.getJobCustomer() != null) {
			attributeList.setAdditionalProperty("accountNumber",
					createWorkorderRequest.getJobCustomer() != null
							&& createWorkorderRequest.getJobCustomer().getSiteId() != null
									? createWorkorderRequest.getJobCustomer().getSiteId()
									: "");
			attributeList.setAdditionalProperty("customerId",
					createWorkorderRequest.getJobCustomer() != null
							&& createWorkorderRequest.getJobCustomer().getCustomerId() != null
									? createWorkorderRequest.getJobCustomer().getCustomerId()
									: "");
		}
		attributeList.setAdditionalProperty("text",
				createWorkorderRequest.getJob() != null && createWorkorderRequest.getJob().getJobComment() != null
						? createWorkorderRequest.getJob().getJobComment()
						: "");
		attributeList.setAdditionalProperty("workOrderId", workOrderNum != null ? workOrderNum : "");
		saveNoteRequest.setFieldsList(attributeList);
		saveRequest.setSaveNoteRequest(saveNoteRequest);
		return saveRequest;

	}

}
