/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker.dao.impl.queue;

import br.net.gvt.efika.mongo.dao.AbstractMongoDAO;
import br.net.gvt.efika.mongo.dao.MongoEndpointEnum;
import br.net.gvt.efika.worker.model.entity.QueueTaskMirror;

public class QueueDAOMirrorImpl extends AbstractMongoDAO<QueueTaskMirror> {

    public QueueDAOMirrorImpl() {
        super(MongoEndpointEnum.MONGO.getIp(), "worker", QueueTaskMirror.class);
    }

}
