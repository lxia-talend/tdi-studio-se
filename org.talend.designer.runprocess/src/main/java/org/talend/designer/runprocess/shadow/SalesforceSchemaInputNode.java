// ============================================================================
//
// Copyright (C) 2006-2009 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.designer.runprocess.shadow;

import java.util.List;

import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.utils.TalendTextUtils;
import org.talend.repository.preview.SalesforceSchemaBean;

/**
 * DOC YeXiaowei class global comment. Detailled comment <br/>
 * 
 */
public class SalesforceSchemaInputNode extends FileInputNode {

    private List<IMetadataTable> metadatas = null;

    public SalesforceSchemaInputNode(List<IMetadataTable> metadatas, SalesforceSchemaBean schemaBean) {
        super("tSalesforceInput"); //$NON-NLS-1$
        addParameters(schemaBean);
        setMetadataList(metadatas);
    }

    /**
     * DOC YeXiaowei Comment method "addParameters".
     * 
     * @param schemaBean
     */
    private void addParameters(SalesforceSchemaBean schemaBean) {
        String[] parameters = new String[] { "ENDPOINT", "USER", "PASS", "MODULENAME", "CONDITION", "CUSTOM_MODULE" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
        String[] values = new String[] { schemaBean.getWebServerUrl(), schemaBean.getUserName(), schemaBean.getPassword(),
                schemaBean.isUseCustomModule() ? "CustomModule" : schemaBean.getModuleName(), schemaBean.getQueryCondition(), //$NON-NLS-1$
                schemaBean.getModuleName() };
        for (int i = 0, n = values.length; i < n; i++) {
            if (values[i] == null || values[i].equals("")) { //$NON-NLS-1$
                continue;
            }
            TextElementParameter param = null;
            if (parameters[i].equals("MODULENAME")) { //$NON-NLS-1$
                param = new TextElementParameter(parameters[i], values[i]);
            } else {
                param = new TextElementParameter(parameters[i], TalendTextUtils.addQuotes(values[i]));
            }
            addParameter(param);
        }
    }

    /**
     * Getter for metadatas.
     * 
     * @return the metadatas
     */
    public List<IMetadataTable> getMetadatas() {
        return this.metadatas;
    }

    /**
     * Sets the metadatas.
     * 
     * @param metadatas the metadatas to set
     */
    public void setMetadatas(List<IMetadataTable> metadatas) {
        this.metadatas = metadatas;
    }
}
