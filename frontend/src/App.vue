<template>
  <div id="app">
    <TodoHeader></TodoHeader>
    <TodoInput v-on:addTodo="addTodo"></TodoInput>
    <TodoList v-bind:propsdata="todoItems" @removeTodo="removeTodo" @updateTodo="updateTodo"></TodoList>
    <TodoFooter v-on:removeAll="clearAll"></TodoFooter>
  </div>
</template>

<script>
import TodoHeader from './components/TodoHeader'
import TodoInput from './components/TodoInput'
import TodoList from './components/TodoList'
import TodoFooter from './components/TodoFooter'
export default {
  data () {
    return {
      todoItems: []
    }
  },
  created () {
    var dbSize
    this.$http.get('/todo/size').then((size) => {
      dbSize = size.data
      for (var i = 1; i <= dbSize; i++) {
        this.$http.get('/todo/findOne/' + i).then((contents) => {
          this.todoItems.push(contents.data)
        })
      }
    })
    // this.$http.get('/todo/list').then((list) => {
    //   this.todoItems = list.data
    // })
  },
  methods: {
    addTodo (todoItem) {
      this.$http.get('/todo/addTodo/' + todoItem).then().catch()
      this.todoItems.push(todoItem)
    },

    clearAll () {
      this.$http.get('todo/deleteAll').then().catch()
      this.todoItems = []
    },
    removeTodo (todoItem, index) {
      this.todoItems.splice(index, 1)
      this.$http.get('/todo/delete/' + ++index).then().catch()
    },
    updateTodo (modifiedItem, index) {
      this.todoItems.splice(index, 1, modifiedItem)
      this.$http.get('/todo/update/' + ++index + '/' + modifiedItem).then().catch()
      modifiedItem = ''
    }
  },
  components: {
    'TodoHeader': TodoHeader,
    'TodoInput': TodoInput,
    'TodoList': TodoList,
    'TodoFooter': TodoFooter
  }
}
</script>

<style>
  body {
    text-align: center;
    background-color: #F6F6F8;
  }
  input {
    border-style: groove;
    width: 200px;
  }
  button {
    border-style: groove;
  }
  .shadow {
    box-shadow: 5px 10px 10px rgba(0, 0, 0, 0.03)
  }
</style>
