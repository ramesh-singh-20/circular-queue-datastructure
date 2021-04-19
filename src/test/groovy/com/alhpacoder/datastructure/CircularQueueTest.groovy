package com.alhpacoder.datastructure

import spock.lang.Specification

class CircularQueueTest extends Specification{

    def 'Test CircularQueue | isEmpty() | Queue is empty'(){
        given:
        def queue= new CircularQueue()

        when:
        def result= queue.isEmpty()

        then:
        result
    }

    def 'Test CircularQueue | isEmpty() | Queue is not empty'(){
        given:
        def queue= new CircularQueue()
        queue.enQueue(0)

        when:
        def result= queue.isEmpty()

        then:
        !result
    }

    def 'Test CircularQueue | front() | Queue is empty'(){
        given:
        def queue= new CircularQueue()

        when:
        queue.front()

        then:
        def e= thrown(UnsupportedOperationException)
        e.message== "Queue is empty."
    }

    def 'Test CircularQueue | front() | Queue is not empty'(){
        given:
        def queue= new CircularQueue()
        queue.enQueue(0)

        when:
        def result= queue.front()

        then:
        result== 0
    }

    def 'Test CircularQueue | enQueue() | Add single element to queue'(){
        given:
        def queue= new CircularQueue()

        when:
        queue.enQueue(0)

        then:
        queue.front()== 0

        and:
        !queue.isEmpty()
    }

    def 'Test CircularQueue | enQueue() | Add multiple element to queue'(){
        given:
        def queue= new CircularQueue()

        when:
        queue.enQueue(0)
        queue.enQueue(1)
        queue.enQueue(2)

        then:
        queue.front()== 0

        and:
        !queue.isEmpty()
    }

    def 'Test CircularQueue | enQueue() | Adding elements when queue is full'(){
        given:
        def queue= new CircularQueue()
        queue.enQueue(0)
        queue.enQueue(1)
        queue.enQueue(2)
        queue.enQueue(3)
        queue.enQueue(4)

        when:
        queue.enQueue(5)

        then:
        def e=thrown(UnsupportedOperationException)
        e.message== "Cannot add elements as queue is full."

        and:
        !queue.isEmpty()
    }

    def 'Test CircularQueue | deQueue() | queue is empty'(){
        given:
        def queue= new CircularQueue()

        when:
        queue.deQueue()

        then:
        def e=thrown(UnsupportedOperationException)
        e.message== "Cannot remove elements as queue is empty."

        and:
        queue.isEmpty()
    }

    def 'Test CircularQueue | deQueue() | queue is not empty and single element'(){
        given:
        def queue= new CircularQueue()
        queue.enQueue(0)

        when:
        queue.deQueue()

        then:
        queue.isEmpty()
    }

    def 'Test CircularQueue | deQueue() | queue is not empty and multiple element'(){
        given:
        def queue= new CircularQueue()
        queue.enQueue(0)
        queue.enQueue(1)

        when:
        def result= queue.deQueue()

        then:
        !queue.isEmpty()

        and:
        result== 0
        queue.front()== 1
    }

    def 'Test CircularQueue | deQueue() | queue is full and deleting all element'(){
        given:
        def queue= new CircularQueue()
        queue.enQueue(0)
        queue.enQueue(1)
        queue.enQueue(2)
        queue.enQueue(3)
        queue.enQueue(4)

        when:
        def result= queue.deQueue()
        def result1= queue.deQueue()
        def result2= queue.deQueue()
        def result3= queue.deQueue()
        def result4= queue.deQueue()

        then:
        queue.isEmpty()

        and:
        result== 0
        result1== 1
        result2== 2
        result3== 3
        result4== 4
    }

    def 'Test CircularQueue | deQueue() | queue is empty and deleting elements'(){
        given:
        def queue= new CircularQueue()
        queue.enQueue(0)
        queue.enQueue(1)
        queue.enQueue(2)
        queue.enQueue(3)
        queue.enQueue(4)

        queue.deQueue()
        queue.deQueue()
        queue.deQueue()
        queue.deQueue()
        queue.deQueue()

        when:
        queue.deQueue()

        then:
        queue.isEmpty()

        and:
        def e= thrown(UnsupportedOperationException)
        e.message== "Cannot remove elements as queue is empty."
    }

    def 'Test CircularQueue | enQueue() | adding elements when queue is filled once'(){
        given:
        def queue= new CircularQueue()
        queue.enQueue(0)
        queue.enQueue(1)
        queue.enQueue(2)
        queue.enQueue(3)
        queue.enQueue(4)

        queue.deQueue()


        when:
        queue.enQueue(5)

        then:
        !queue.isEmpty()

        and:
        queue.front()== 1
    }

    def 'Test CircularQueue | enQueue() | adding elements when queue is filled once and deleting all elements except one'(){
        given:
        def queue= new CircularQueue()
        queue.enQueue(0)
        queue.enQueue(1)
        queue.enQueue(2)
        queue.enQueue(3)
        queue.enQueue(4)

        queue.deQueue()


        when:
        queue.enQueue(5)
        queue.deQueue()
        queue.deQueue()
        queue.deQueue()
        queue.deQueue()

        then:
        !queue.isEmpty()

        and:
        queue.front()== 5
    }

    def 'Test CircularQueue | enQueue() | adding elements when queue is filled once and deleting all elements'(){
        given:
        def queue= new CircularQueue()
        queue.enQueue(0)
        queue.enQueue(1)
        queue.enQueue(2)
        queue.enQueue(3)
        queue.enQueue(4)

        queue.deQueue()


        when:
        queue.enQueue(5)
        queue.deQueue()
        queue.deQueue()
        queue.deQueue()
        queue.deQueue()
        queue.deQueue()

        then:
        queue.isEmpty()

    }

    def 'Test CircularQueue | enQueue() | adding elements when queue is filled once and adding when queue is full'(){
        given:
        def queue= new CircularQueue()
        queue.enQueue(0)
        queue.enQueue(1)
        queue.enQueue(2)
        queue.enQueue(3)
        queue.enQueue(4)

        queue.deQueue()


        when:
        queue.enQueue(5)
        queue.enQueue(6)

        then:
        def e= thrown(UnsupportedOperationException)
        e.message== "Cannot add elements as queue is full."

    }

    def 'Test CircularQueue | enQueue() | adding elements when queue is filled once and deleting when queue is empty'(){
        given:
        def queue= new CircularQueue()
        queue.enQueue(0)
        queue.enQueue(1)
        queue.enQueue(2)
        queue.enQueue(3)
        queue.enQueue(4)

        queue.deQueue()


        when:
        queue.enQueue(5)
        queue.deQueue()
        queue.deQueue()
        queue.deQueue()
        queue.deQueue()
        queue.deQueue()
        queue.deQueue()

        then:
        def e= thrown(UnsupportedOperationException)
        e.message== "Cannot remove elements as queue is empty."

    }
}
