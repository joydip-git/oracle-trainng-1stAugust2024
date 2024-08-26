/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */

import { RESTDataProvider } from "ojs/ojrestdataprovider";
import { Todo } from "../../models/todo";
import { useState, useEffect, useRef } from "preact/hooks";

export function Content() {
  const url = 'https://jsonplaceholder.typicode.com/todos'

  const [todoDP, setTodoDP] = useState<RESTDataProvider<Todo['id'], Todo> | undefined>(undefined)
  const [fetchCompleted, setFetchCompleted] = useState(false)
  const errorInfo = useRef<string>('')

  useEffect(
    () => {
      const dp = new RESTDataProvider<Todo['id'], Todo>({
        keyAttributes: 'id',
        url: url,
        error: (errorResp: RESTDataProvider.FetchErrorDetail<number, Todo> | RESTDataProvider.FetchResponseErrorDetail<number, Todo>) => {
          if (errorResp.hasOwnProperty('response')) {
            const responseError = errorResp as RESTDataProvider.FetchResponseErrorDetail<Todo['id'], Todo>
            errorInfo.current = responseError.response.body
          } else {
            const error = errorResp as RESTDataProvider.FetchErrorDetail<Todo['id'], Todo>
            errorInfo.current = error.error.message
          }
        },
        transforms: {
          fetchFirst: {
            request: async (options) => {
              const restUrl = new URL(options.url)
              return new Request(restUrl.href)
            },
            response: async (resp) => {
              const { body } = resp
              return { data: body }
            }
          }
        }
      })
      setTodoDP(dp)
      setFetchCompleted(true)
    },
    []
  )
  return (
    <div class="oj-web-applayout-max-width oj-web-applayout-content">

    </div>
  );
};
