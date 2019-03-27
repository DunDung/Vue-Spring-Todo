<template>
  <div>
    <input type="text" v-model="newTodoItem">
    <button v-on:click="addTodo">추가</button>
  </div>
</template>

<script>
export default {
  data () {
    return {
      newTodoItem: ''
    }
  },
  methods: {
    addTodo () {
      var contents = this.newTodoItem && this.newTodoItem.trim()
      if (contents !== '') {
        this.$http.get('/todo/addTodo/' + contents).then().catch()
        this.clearInput()
      }
    },
    clearInput () {
      this.newTodoItem = ''
    }
  }
}
</script>

<style>

</style>
